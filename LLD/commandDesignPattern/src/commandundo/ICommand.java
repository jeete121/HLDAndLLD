package commandundo;

//Command
public interface ICommand {

	public void execute();

	public void undo();

}