package visitor;

import mvc.Multitude;

public class VisitorPerson implements Visitor {
    @Override
    public Integer cardinality(Multitude multitude) {
        int cardinality = 0;
        for (int i = 0; i < multitude.getMultitude().size(); i++) {
            if (multitude.getMultitude().get(i) == 1){
                ++cardinality;
            }
        }
        return cardinality;
    }
}
