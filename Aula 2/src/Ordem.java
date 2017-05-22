

public class Ordem {
	
	public String crescente(int num1,int num2,int num3)
	{
		String ok = "";
		
		if(num1 < num2 && num1 < num3)
		{
			if(num2<num3)
			{
				
				ok=String.valueOf(num1)+String.valueOf(num2)+String.valueOf(num3);
			}
			else ok=String.valueOf(num1)+String.valueOf(num3)+String.valueOf(num2);
		}
		
		if(num2 < num1 && num2 < num3)
		{
			if(num1<num3)
			{
				ok=String.valueOf(num2)+String.valueOf(num1)+String.valueOf(num3);
			}
			else ok=String.valueOf(num2)+String.valueOf(num3)+String.valueOf(num1);
		}
		
		if(num3 < num1 && num3 < num2)
		{
			if(num1<num2)
			{
				ok=String.valueOf(num3)+String.valueOf(num1)+String.valueOf(num2);
			}
			else ok=String.valueOf(num3)+String.valueOf(num2)+String.valueOf(num1);
		}			
		return ok;
	}
	
}
