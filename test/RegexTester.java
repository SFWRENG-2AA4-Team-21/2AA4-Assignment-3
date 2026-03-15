public class RegexTester {
    public String parse(String str){
        if(str.matches("^Roll$")){
            return "Dice Rolled";
        }else if(str.matches("^Go$")){
            return "Movement Enacted\nTurn Ended";
        }else if(str.matches("^List$")){
            return "Here's a list of your cards on hand";
        }else if(str.matches("^Build (settlement|city) (\\d+)$")||str.matches("^Build (road) (\\d+),(\\d+)$")){
            return "Building your card";
        }
        return "Failed Result";
    }

}

