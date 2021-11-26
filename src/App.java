import java.io.File;
import java.io.FileNotFoundException;  
import java.util.Scanner;
import java.util.Stack; 
import java.util.ArrayList; 
public class App {

    public static void main(String[] args) throws Exception {
        Stack<Integer> stack = new Stack<Integer>();
        ArrayList<Token> tokenList = new ArrayList<>();

        try{
            
            //Scanner
            File file = new File("Calc1.stk");
            Scanner reader = new Scanner(file);

            while(reader.hasNextLine()){
                String data = reader.nextLine();
                Token token = new Token(data);
                tokenList.add(token);
            }
            reader.close();

            System.out.println(tokenList.toString());

            //Realizando Operações
            for(int i=0; i<tokenList.size(); i++){
                
                TokenType type = tokenList.get(i).type;
                
                if(type == TokenType.PLUS){
                    int a = stack.pop();
                    int b = stack.pop();
                    int result = b + a;
                    stack.push(result);

                }else if(type == TokenType.MINUS){
                    int a = stack.pop();
                    int b = stack.pop();
                    int result = b - a;
                    stack.push(result);

                }else if(type == TokenType.STAR){    
                    int a = stack.pop();
                    int b = stack.pop();
                    int result = b * a;
                    stack.push(result);

                }else if(type == TokenType.SLASH){
                    int a = stack.pop();
                    int b = stack.pop();
                    int result = b / a;
                    stack.push(result);

                }else if(type == TokenType.NUM){

                    stack.push(Integer.parseInt(tokenList.get(i).lexeme));
                }
            }
            
            System.out.println(stack.pop());

        }catch(FileNotFoundException e){
            System.out.println("We not found the file!");
            e.printStackTrace();
        }
        
    }
}
