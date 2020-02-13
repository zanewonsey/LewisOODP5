package me.wonsey.ood.states;

import me.wonsey.ood.device.Dog;

public class SittingState implements State
{
   Dog good_pupper;
   
   public SittingState(Dog good_pupper)
   {
      this.good_pupper = good_pupper;
   }

   @Override
   public void giveTreat()
   {
      System.out.println(good_pupper.getName()+" was so excited it started playing");
      good_pupper.setState(good_pupper.getPlaying());
   }

   @Override
   public void callOver()
   {
      System.out.println(good_pupper.getName()+" ignored you and lays down");
      good_pupper.setState(good_pupper.getSleeping());
   }

   @Override
   public void callLoudly()
   {
      System.out.println(good_pupper.getName()+" starts to run over");
      good_pupper.setState(good_pupper.getRunning());
   }
}
