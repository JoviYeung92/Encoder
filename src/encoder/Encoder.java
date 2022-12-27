package encoder;



public class Encoder {
	
	final String refTable = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789()*+,-./ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789()*+,-./ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789()*+,-./";
	
	public String encode(String plaintext,char offsetChar) {
		StringBuilder encoded = new StringBuilder();
		int anciiValOffset = offsetChar; //change to dec val
		int actualOffsetValue = 0; 
		
		encoded.append(offsetChar); //append the first char
		
		//First get the offset value from the first char
		if(anciiValOffset>64 && anciiValOffset<91) //A-Z
		{ 
			actualOffsetValue = anciiValOffset - 65;
		} 
		else if(anciiValOffset>47 && anciiValOffset<58)//0-9
		{
			actualOffsetValue = anciiValOffset - 22;
		}
		else if(anciiValOffset>39 && anciiValOffset<48) //( - /
		{
			actualOffsetValue = anciiValOffset - 4;
		}
		
		//loop through the plaintext and map each char by shifting them using
		//the final refTable variable declared above
		//using the formula (44 + IndexValue - offset)
		for(int i=0;i<plaintext.length();i++) {
			int charVal = plaintext.charAt(i);
			
			if(charVal>64 && charVal<91) //A-Z
			{ 
				encoded.append(refTable.charAt(44+(charVal-65)-actualOffsetValue));
			} 
			else if(charVal>47 && charVal<58)//0-9
			{
				encoded.append(refTable.charAt(44+(charVal-22)-actualOffsetValue));
			}
			else if(charVal>39 && charVal<48) //( - /
			{
				encoded.append(refTable.charAt(44+(charVal-4)-actualOffsetValue));
			} else 
			{
				encoded.append(plaintext.charAt(i)); //if not from the table map back to the same char
			}
		}
		
		
		return encoded.toString();
	}
	
}
