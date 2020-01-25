package payroll;

public class PieceWorker extends Employee {
	// Variables
	private double wage;
	private int pieces;
	
	// Constructor
	public PieceWorker(String firstName, String lastName, String socialSequrityNumber, double wage, int pieces)
	{
		super(firstName, lastName, socialSequrityNumber);
		setWage(wage);
		setPieces(pieces);
	}
	
	// Getter & Setter
	public double getWage()
	{
		return wage;
	}
	
	public void setWage(double wage)
	{
		if (wage > 0)
		{
			this.wage = wage;
		}
		else
		{
			throw new IllegalArgumentException(" Wage cannot be zero or negative.\n");
		}
	}
	
	public int getPieces()
	{
		return pieces;
	}
	
	public void setPieces(int pieces)
	{
		if (pieces > 0)
		{
			this.pieces = pieces;
		}
		else
		{
			throw new IllegalArgumentException(" Pieces cannot be zero or negative.\n");
		}
	}
	
	// Methods
	@Override
	public double earnings()
	{
		return wage * pieces;
	}
	
	@Override
	public String toString()
	{
		return String.format("%s: %s%n%s: $%,.2f; %s: %d",     
		         "piece worker", super.toString(),              
		         "wage", getWage(),                       
		         "pieces", getPieces());
	}
}