public class MyMain {
    // This method returns true/false if there 
    // was a boat the specified coordinates. This
    // method also prints out an appropriate message
    public static boolean hit(boolean[][] board, int row, int col) { 
        boolean hit_place = board[row][col];
        if(hit_place == true){
            System.out.println("There was a hit!");
            return true;
        }
        else{
            System.out.println("You missed!");
            return false;
        }
    }


    // Places a boat onto the board
    // The top-left piece of the board is located at (row, col)
    // The remaining pieces are placed in the direction given
    // by the direction input
    public static boolean[][] placeBoat(boolean[][] board, String direction, int boatLength, int row, int col) { 
        board[row][col] = true;
        if(direction.equals("right")){
            for(int j = col; j<col+boatLength; j++){
                board[row][j] = true;
            }
        }
        else if(direction.equals("down")){
            for(int i = row; i<row+boatLength; i++){
                board[i][col] = true;
            }
        }
        else{
            System.out.println("Invalid input detected. Please try again.");
            return null;
        }
        return board;
    }

    // Returns true if the every row in the 2D array
    // is in both alphabetical order and in order of 
    // increasing length
    // You may assume that all Strings are lowercase 
    public static boolean inOrder(String[][] words) {
        for(int i = 0; i<words.length; i++){
            for(int j = 0; j<words[0].length; j++){
                int before = words[i][j].length();
                int after = words[(words.length-1)-i][(words.length-1)-j].length();
                char before_char_conv = words[i][j].charAt(0);
                char after_char_conv = words[(words.length-1)-i][(words.length-1)-j].charAt(0);
                int before_char = before_char_conv;
                int after_char = after_char_conv;
                if(before>after && before_char>after_char){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean[][] test_board = new boolean[5][5];
        placeBoat(test_board, "down", 2, 3, 4);
        for(int i = 0; i<test_board.length; i++){
            for(int j = 0; j<test_board[0].length; j++){
                System.out.print(test_board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(hit(test_board, 3, 4)); //(testing row = 3 x col = 4)
        System.out.println(hit(test_board, 1, 2)); //false scenario
        String[][] string_board = {{"a", "bd", "cdkd"}, {"b", "cka", "dks"}};
        String[][] string_board_false = {{"a", "g", "cdkd"}, {"b", "cka", "dks"}};
        System.out.println(inOrder(string_board));
        System.out.println(inOrder(string_board_false));
    }
}
