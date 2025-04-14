package L16.cyborg;

public interface Roboter extends Autofahren {
	public void aufladen();
	public void warten();
	// should this also be abstracted?
	public void arbeiten();
}
