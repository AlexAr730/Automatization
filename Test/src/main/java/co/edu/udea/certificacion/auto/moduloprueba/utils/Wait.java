package co.edu.udea.certificacion.auto.moduloprueba.utils;

public class Wait {
  
    private  static Wait wait;

    public Wait(Integer mill){
        try{
             Thread.sleep(mill);

        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static Wait aLittleBitTime(Integer mills) {

        wait = new Wait(mills);
        return wait;
    }
}