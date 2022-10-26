#ifndef LAB__3_BUFFERED_CHANNEL_H
#define LAB__3_BUFFERED_CHANNEL_H

#include <utility>
#include <mutex>
#include <queue>
#include <condition_variable>
#include <atomic>


template<typename T>
class BufferedChannel{
public:
    explicit BufferedChannel(int size) : buffer_size(size), channelClose(false){}

    void Send(T&& value){

        if (channelClose){
            throw std::runtime_error("channel is closed");
        }

        std::unique_lock<std::mutex> locker(g_lock);

        queueCheck.wait(locker, [this]{
            return taskQueue.size() < buffer_size;
        });

        taskQueue.push(std::move(value));
        queueCheck.notify_one();
    }

    std::pair<T, bool> Recv(){
        if (channelClose && taskQueue.empty()){
            return std::make_pair(T(), false);
        }

        std::unique_lock<std::mutex> locker(g_lock);

        queueCheck.wait(locker, [this]{
            return taskQueue.size() != 0;
        });

        T res = taskQueue.front();

        taskQueue.pop();

        queueCheck.notify_one();

        return std::make_pair(res, true);
    }

    void Close(){
        channelClose = false;
        queueCheck.notify_all();
    }

private:
    int buffer_size;
    std::mutex g_lock;
    std::queue<T> taskQueue;
    std::condition_variable queueCheck;
    std::atomic<bool> channelClose;
};

#endif //LAB__3_BUFFERED_CHANNEL_H
