#include <iostream>
#include "buffered_channel.h"

int main() {
    BufferedChannel<int> ch(6);
    ch.Send(1);
    ch.Send(2);
    ch.Send(3);
    ch.Send(4);
    ch.Send(5);
    ch.Send(6);
    ch.Close();

    std::pair<int, bool> p1 = ch.Recv();
    std::pair<int, bool> p2 = ch.Recv();
    std::pair<int, bool> p3 = ch.Recv();
    std::pair<int, bool> p4 = ch.Recv();
    std::pair<int, bool> p5 = ch.Recv();
    std::pair<int, bool> p6 = ch.Recv();

    std::cout << p1.first << "  " << p1.second << std::endl;
    std::cout << p2.first << "  " << p2.second << std::endl;
    std::cout << p3.first << "  " << p3.second << std::endl;
    std::cout << p4.first << "  " << p4.second << std::endl;
    std::cout << p5.first << "  " << p5.second << std::endl;
    std::cout << p6.first << "  " << p6.second << std::endl;
    return 0;
}
