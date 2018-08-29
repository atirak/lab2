public class ox {
    private String[][] table = {
            {" ","0","1","2"} ,
            {"0","-","-","-"} ,
            {"1","-","-","-"} ,
            {"2","-","-","-"}
    };
    private String player;
    private int countX;
    private int countO;
    private int countDraw;
    private int turnCount;

    public ox() {
        player = "X";
        countX = 0;
        countO = 0;
        countDraw = 0;
        turnCount=0;
    }

    public String getTableString() {
        String result = "";
        for (int row = 0; row < table.length; row++){
            for (int col = 0; col < table[row].length; col++){
                result = result + table[row][col];
            }
            result = result + "\n";
        }
        return result;
    }

    public String getCurrentPlayer() {
        return player;
    }

    public int getCountO() {
        return countO;
    }

    public int getCountX() {
        return countX;
    }

    public int getCountDraw() {
        return countDraw;
    }

    public boolean put(int col, int row) {
       try{
           if(!table[row+1][col+1].equals("-")){
               return false;
           }
       }catch (ArrayIndexOutOfBoundsException e){
           return false;
       }
        table[row+1][col+1] = getCurrentPlayer();
        turnCount++;
        if(checkWin(col,row)){
            if(getCurrentPlayer().equals("X")){
                countX++;
            }else if(getCurrentPlayer().equals("O")){
                countO++;
            }
        }
        if(isDraw()){
            countDraw++;
        }
        return true;
    }


    public void switchPlayer() {
        if(player.equals("X")) {
            player = "O";
        }else{
            player = "X";
        }
    }

    public boolean checkWin(int col, int row) {
        boolean colWin = true;
        for(int i = 0; i < 3; i++){
            if(!table[i+1][col+1].equals(getCurrentPlayer())){
                colWin = false;
            }
        }if(colWin) {
            return true;
        }
        boolean rowWin = true;
        for(int i = 0; i < 3; i++){
            if(!table[row+1][i+1].equals(getCurrentPlayer())){
                rowWin = false;
            }
        }if(rowWin) {
            return true;
        }
        boolean esWin = true;
        for(int i = 0; i < 3; i++){
            if(!table[i+1][i+1].equals(getCurrentPlayer())){
                esWin = false;
            }
        }if(esWin) {
            return true;
        }
        boolean ssWin = true;
        for(int i = 0; i < 3; i++){
            if(!table[i+1][3-i].equals(getCurrentPlayer())){
                ssWin = false;
            }
        }if(ssWin) {
            return true;
        }
        return false;
    }

    public boolean isDraw() {
        if(turnCount<9){
            return false;
        }
        return true;
    }

    public void reset() {
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                table[i+1][j+1] = "-";
            }
        } player = "X";
        turnCount = 0;
    }

}
