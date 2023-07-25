
package ch.teko.loefflee;


public class GameBoard {
    
    char [][] gameBoard ={  {' ', ' ', ' '},
                            {' ', ' ', ' '}, 
                            {' ', ' ', ' '},};

    void setvalue(int line, int column){
        gameBoard[line][column] = 'X';
    }  
}
