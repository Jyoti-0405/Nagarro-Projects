package nagarro_ds_ht;
import java.util.Scanner;
public class Main {
	public static void main(String[] args)
	{   HashTable hp=new HashTable();
		int b=1;
	    @SuppressWarnings("resource")
	    Scanner sc = new Scanner(System.in);
		while (b==1)
	    {
    		System.out.println("1.Insert\r\n"
    				+ "2 Delete\r\n"
    				+ "3 Contains\r\n"
    				+ "4 Get Value by key\r\n"
    				+ "5 Size\r\n"
    				+ "6 Iterator\r\n"
    				+ "7 Traverse/Print\r\n"
    				+ "");
    		System.out.println("Enter choice :");
			int method=sc.nextInt();
			switch(method)
	        {
	        case 1:
	        	System.out.println("enter key "+ "");
	        	int key=sc.nextInt();
	        	System.out.println("enter value");
	    		int value=sc.nextInt();
        		hp.Push(key,value);
        		break;
        	
            case 2:
            	System.out.print("enter key");
            	int key1=sc.nextInt();
            	hp.Pop(key1);
	        	break;
	        	
	        case 3:
	        	System.out.print("enter the key whose value you want to find");
	        	int key11=sc.nextInt();
	        	hp.Get_VALUE_From_KEY(key11);
	        	break;
	        	
            case 4://size of hashtable
            	hp.SIZE();
	        	break;
	        	
            case 5://contain key in hashtable
            	System.out.print("enter the key which you want to check is present or not \n");
            	int a=sc.nextInt();
            	hp.CONTAIN(a);
            	break;
	        	
	        case 6://iterate the hashtable
	        	System.out.print("iterate the whole stack:\n ");
	        	hp.Iterator();
	        	break;
	        	
            case 7://traverse the hashtable
            	System.out.print("traverse of whole stack is:\n  ");
            	hp.Traverse();
	        	break;
	        	
	        default:
	        	System.out.print(" no match");
	        	break;
	        	} 	
	        System.out.println("do you want to perform more operations : ");
	 	    char s5= sc.next().charAt(0);
	        int x5=Character.compare(s5, 'y');
	 	    if (x5==0)
	 	    {
	 	    	b=1;			 	    
	 	    }
	 	    else
	 	    {
	 	    	b=0;
	 	    }
	 	    }	    	
	    }

}
