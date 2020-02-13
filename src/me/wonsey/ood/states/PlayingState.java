package me.wonsey.ood.states;

import me.wonsey.ood.device.Dog;

public class PlayingState implements State
{

   Dog good_pupper;
   
   public PlayingState(Dog good_pupper)
   {
      this.good_pupper = good_pupper;
   }

   @Override
   public void giveTreat()
   {
      System.out.println(good_pupper.getName()+" stops playing and starts eating the treat");
      good_pupper.setState(good_pupper.getEating());
   }

   @Override
   public void callOver()
   {
      System.out.println(good_pupper.getName()+" runs over");
      good_pupper.setState(good_pupper.getRunning());
   }

   @Override
   public void callLoudly()
   {
      System.out.println(good_pupper.getName()+" sits in defiance!");
      good_pupper.setState(good_pupper.getSitting());
   }
}
