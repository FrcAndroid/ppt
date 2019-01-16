import java.util.Random;

public class MoveWords{

    public static final int EMPATE = 0;
    public static final int GANA = 1;
    public static final int PIERDE = 2;

    private static final String[] validMoves = {"PIEDRA", "SPOCK", "PAPEL", "LAGARTO", "TIJERAS"};
    private static final String[] validCommands = {"SALIR", "HELP"};

    private Random rnd;
    
    public MoveWords(){
    	rnd = new Random();
    }
    
    public boolean isValidMoveCommand(String value){

	    for (int i =0; i< validMoves.length; i++){
	        if(validMoves[i].equals(value))
	    	    return true;
	    }
	    
	    for (int i =0; i< validCommands.length; i++){
	        if(validCommands[i].equals(value))
		        return true;
	    }
	    
	    return false;
    }

    public String randomMove(){
	    float p = rnd.nextFloat();
	    return validMoves[ (int) (p * validMoves.length)];
    }

    public void showMoves(){
        for (String move : validMoves)
	        System.out.print(move+" ");
	    System.out.println();
    }
    public void showCommands(){
	    for (String cmd : validCommands)
	        System.out.print(cmd+" ");
	    System.out.println();
    }

    public void showWords(){
        showMoves();
        showCommands();    
    }

    private static int getIndex(String value){
	    for (int i =0; i< validMoves.length; i++){
	        if(validMoves[i].equals(value))
		        return i;
	    }
    	return -1;
    }

    public static int checkWinner(String first, String second){
	    int first_i, second_i;

	    first_i = getIndex(first);
	    second_i = getIndex(second);

	    if (first_i == second_i) return EMPATE;
	    
	    if (( (second_i +1) % validMoves.length ) == first_i ) return GANA;
	    
	    if (( (second_i +2) % validMoves.length ) == first_i ) return GANA;
	    
	    else return PIERDE;
	    //return (( (first_i +1) % validMoves.length ) == second_i ) ? GANA: PIERDE;
	}
	//Si first_i=0 es TIJERAS, 1 es PAPEL, 2 es PIEDRA
    //Si escogemos i=2 PIEDRA, 2+1=3 3%3=1
    //1 corresponde a TIJERAS, por lo tanto como 1==1, ganas.
    //Correspondiendo a esto, si eliges SPOCK y te enfrentas a PIEDRA
    //SPOCK es 5+1=6 6%5=1 1=/=2 por lo tanto PIERDES
    //
} 
