import java.io.*;

public class WordCount {
	public static void main(String [] args) throws IOException {
		
		BufferedReader reader;
		
		if(!parseArgs(args)) {
			
			System.out.println("Argument error");
		}
		else {
			
			File input = new File(args[args.length-1]);
			reader = new BufferedReader(new FileReader(input));
		
				try {
					int current;
					int previous=0;
					int wordCount=0;
					
					current=reader.read();
					
						if(current!=32 && current!=13 && current!=-1 && current!=10) {
							wordCount++;
							previous=current;
						}
						while((current=reader.read())!=-1) {
							if((previous==10 || previous==32) && (current!=13 && current!=32)) {
								
								wordCount++;
							}
							
							previous=current;
						}
				
					System.out.println("Word Count: "+ wordCount);
				}
				finally {
					if(reader!=null) {
						reader.close();
					}
				}
		}
	}
	
	public static boolean parseArgs(String [] args)
	{
		boolean correctArgs=true;
		int i = 0;
		
		if(args.length==0) {
			
			correctArgs=false;
		}
		while(i<args.length) {
			if(args[i].equals("-w")) {
				
				i++;
			}
			else {
				File inputFile;
				
				try {
					inputFile = new File(args[i]);
					
					if(!inputFile.exists())
					{
						correctArgs=false;
					}
					
					i++;
				}
				catch(Exception e)
				{
					correctArgs=false;
					break;
				}
			}
		}
		
		if(args.length==1) {
			correctArgs=false;
		}
		
		return correctArgs;
	}
}