InterPreter Design Pattern::


Pattern Category: It's a behavioral pattern.


So, its based on CONTEXT what we interpret.



      Components Involved:
             |
  ___________|___________________
 |                               |
 |                               |
 |                               |
Context                        Abstract Expresion
                                 |
                       __________|___________
                      |                      |
                      |                      |
                 Terminal Expression      Non Terminal Expression




                                  <<Interface>>
    Client --------------------> Abstract Expression<-----------
     |                           +interpret(Context)            |
     |                                 |                        |
     |                        _________|____________            |
    Context                  |                      |           |
                             |is-a                  |           |
                             |                      |           |
                     Terminal Expression       Non-Terminal Expression
                     +interpret(Context)       +interpret(Context)





public class Client {

public static void main(String[] args) {

//initialize the context
Context context = new Context();
context.put("a", 2);
context.put("b",4);

//a*b
AbstractExpression expression1 = new MultiplyNonTerminalExpression(
           new NumberTerminalExpression("a"),new NumberTerminalExpression("b"));

System.out.println(expression1.interpret(context));
}

}
   

public class Context {

Map<String,Integer> contextMap = new HashMap<>();

public void put(String strVariable,int intValue) {
  contextMap.put(strVariable,intValue);
}

public int get(String strVariable) {
  return contextMap.get(strVariable);
}

}

public interface AbstractExpression {

int interpret(Context context);
}  


public class NumberTerminalExpression implements AbstractExpression {

String stringValue;

NumberTerminalExpression(String stringValue) {
 this.stringValue = stringValue;
}

@Override
public int interpret(Context context) {
  return context.get(stringValue);
}

}


public class MultiplyNonTerminalExpression implements AbstractExpression {

AbstractExpression leftExpression;
AbstractExpression rightExpression;

MultiplyNonTerminalExpression(AbstractExpression leftExpression, 
   AbstractExpression rightExpression) {
 this.leftExpression = leftExpression;
 this.rightExpression = rightExpression;
}

@Override
public int interpret(Context context) {
  return leftExpression.interpret(context)*rightExpression.interpret(context);
}

}



