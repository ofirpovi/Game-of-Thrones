package Game;

public class CmdPrinter implements MessageHandler{
    @Override
    public void sendMessage(String message) {
        System.out.println(message);
    }
}
