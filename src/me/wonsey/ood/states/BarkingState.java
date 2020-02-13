package me.wonsey.ood.states;

import me.wonsey.ood.device.Dog;

public class BarkingState implements State
{
   Dog good_pupper;
   
   public BarkingState(Dog good_pupper)
   {
      this.good_pupper = good_pupper;
   }

   @Override
   public void giveTreat()
   {
      System.out.println(good_pupper.getName()+" quiets down to eat the treat");
      good_pupper.setState(good_pupper.getEating());
      
   }

   @Override
   public void callOver()
   {
      System.out.println(good_pupper.getName()+" stops barking and runs over");
      good_pupper.setState(good_pupper.getRunning());
   }

   @Override
   public void callLoudly()
   {
      System.out.println(good_pupper.getName()+" thinks you are barking so continues");
   }
}
