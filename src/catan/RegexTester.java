package catan;

public class RegexTester {
    public int parse(String str){
        if(str.matches("^Build (Settlement)$")){
            return 0;
        }else if(str.matches("^Build (Road)$")) {
            return 1;
        }else if(str.matches("^Pass$")) {
            return 2;
        }
        return -1;
    }

}
