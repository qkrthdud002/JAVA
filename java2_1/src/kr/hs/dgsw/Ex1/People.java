package kr.hs.dgsw.Ex1;
//
public class People {
	
	String name;
	double height;
	double weight;
	double b;
	
	public void BMI() {
		//double b;
		//int result;
		b = weight/((height/100)*(height/100));
			
	}
	public void printBmi() {
		if(b<20) {
			System.out.printf("%s의 비만도는 %.2f이고 저체중입니다.\n", name, b);
		}
		else if(b<25) {
			System.out.printf("%s의 비만도는 %.2f이고 표준체중입니다.\n", name, b);
		}
		else {
			System.out.printf("%s의 비만도는 %.2f이고 과체중입니다.\n", name, b);
		}
	}
	
	//b = (double)(weight/(height+height));
	

}


//
//public class People {
//   String name;
//   double height;
//   double weight;
//   double res;
//   public void BMI() {
//      res = weight / ((height/100)*(height/100));
//   }
//   public void printBmi() {
//      if(res < 20) {
//         System.out.printf("%s의 비만도는 %.2f이고 저체중입니다.\n",name,res);
//      }
//      else if(res < 25) {
//         System.out.printf("%s의 비만도는 %.2f이고 표준체중입니다.\n",name,res);
//      }
//      else {
//         System.out.printf("%s의 비만도는 %.2f이고 과체중입니다.\n",name,res);
//      }
//   }
//}