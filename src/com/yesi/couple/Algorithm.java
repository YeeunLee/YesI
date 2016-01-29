package com.yesi.couple;

public class Algorithm 
{
	public int[] chosungArr ={2, 4, 2, 3, 6, 5, 4, 4, 8, 2, 4, 1, 3, 6, 4, 3, 4, 4, 3};
    			//            �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� ��
    public int[] joongsungArr = {2, 3, 3, 4, 2, 3, 3, 4, 2, 4, 5, 3, 3, 2, 4, 5, 3, 3, 1, 2, 1};
    				//             �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� ��
    public int[] jongsungArr = {0, 2, 4, 4, 2, 5, 5, 3, 5, 7, 9, 9, 7, 9, 9, 8, 4, 4, 6, 2, 4, 1, 3, 4, 3, 4, 4, 3};
    			//             �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� ��
    
	public Algorithm() {
		// TODO Auto-generated constructor stub
	}
	
	public int strokeCount(char c)
	{
		
		int letter = 0;
		int chosung = 0;
		int joongsung = 0;
		int jongsung = 0;
		int result = 0;
		
		letter = (int)c-44032;
			
		chosung = letter/(21*28);
		joongsung = letter%(21*28)/28;
		jongsung = letter %28;

		result = chosungArr[chosung]+joongsungArr[joongsung]+jongsungArr[jongsung];
		
		return result;
	}
	
	public int percent(String myName,String yourName)
	{
		int myNameLength = myName.length();
		int yourNameLength = yourName.length();
		int totalLength = myNameLength+yourNameLength;
		int[] arr = new int[totalLength];
		
		for(int i = 0;i<myNameLength;i++)
		{
			if(i<yourNameLength)
			{
				arr[i*2] = strokeCount(myName.charAt(i));
			}
			else
			{
				arr[yourNameLength+i] = strokeCount(myName.charAt(i));
			}
		}
		
		for(int i = 0;i<yourNameLength;i++)
		{
			if(i<myNameLength)
			{
				arr[i*2+1] = strokeCount(yourName.charAt(i));
			}
			else
			{
				arr[myNameLength+i] = strokeCount(yourName.charAt(i));
			}
		}
		
		for(int l = totalLength;l>=3;l--)
		{
			for(int i = 1;i<l;i++)
			{
				arr[i-1] = arr[i]+arr[i-1];
				arr[i-1] = arr[i-1]%10;
			}
		}
		
		return arr[0]*10+arr[1];
	}
	
	public String message(String myName,String yourName)
	{
		int couple = 0;

		for(int i = 0;i <myName.length();i++)
		{
			couple += strokeCount(myName.charAt(i));
		}

		for(int i = 0;i <yourName.length();i++)
		{
			couple += strokeCount(yourName.charAt(i));
		}

		String result="";

		couple = couple%40;
		
		
		switch(couple)
		{
		case 0: result = "��� �����"; break;
		case 1: result = "�̺��ϱ� ����"; break;
		case 2: result = "2���̻� ������"; break;
		case 3: result = "���� ���ΰ� �����"; break;
		case 4: result = "������ ���"; break;
		case 5: result = "����"; break;
		case 6: result = "��Ÿ���� ��ٸ�"; break;
		case 7: result = "���� ���"; break;
		case 8: result = "ȥ�� ���"; break;
		case 9: result = "�׾�� ������"; break;
		case 10: result = "������"; break;
		case 11: result = "���� ���"; break;
		case 12: result = "�����鼭 ������"; break;
		case 13: result = "������ ���ݴ�"; break;
		case 14: result = "�ο�"; break;
		case 15: result = "���ڰ� ���ڶ����� ��"; break;
		case 16: result = "������ ���"; break;
		case 17: result = "��� ����"; break;
		case 18: result = "������"; break;
		case 19: result = "�ٽ� ���"; break;
		case 20: result = "����� ���ؼ����"; break;
		case 21: result = "�̺�"; break;
		case 22: result = "�̷��� Ű��"; break;
		case 23: result = "���� �� ���� ���"; break;
		case 24: result = "��ٸ�"; break;
		case 25: result = "���� �� ����Ʈ"; break;
		case 26: result = "���� ���"; break;
		case 27: result = "����� ����"; break;
		case 28: result = "����� �Ǽ�"; break;
		case 29: result = "��ȥ����"; break;
		case 30: result = "���ڰ� ��������"; break;
		case 31: result = "���ڰ� �Ʊ��"; break;
		case 32: result = "���ڰ� ��������"; break;
		case 33: result = "���ڰ� ¦���"; break;
		case 34: result = "���ڰ� ���ڶ����� ��"; break;
		case 35: result = "������ ����"; break;
		case 36: result = "��︮�� ����"; break;
		case 37: result = "���ڰ� �Ʊ��"; break;
		case 38: result = "���ڴ� ���������� ���ڰ� �������� ����"; break;
		case 39: result = "���ڰ� ¦���"; break;
		default: break;
		}

		return result;
	}
}
