public class DiceHolder {
	protected int[] diceArray = new int[5];


     public DiceHolder(int value1, int value2, int value3, int value4, int value5){
         diceArray[0] = value1;
        diceArray[1] = value2;
       diceArray[2] = value3; 
       diceArray[3] = value4;
      diceArray[4] = value5;
     }

     public int getValue(int index){
         return diceArray[index];
      }


      public void setValue(int index, int value){
          diceArray[index] = value;
     }

      public int getTotal(){
          int tempSum = 0;
          for(int i = 0; i < diceArray.length; i++){
                tempSum += diceArray[i];
          }
          return tempSum;
     }
}