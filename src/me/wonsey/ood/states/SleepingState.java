package me.wonsey.ood.states;

import me.wonsey.ood.device.Dog;

public class SleepingState implements State
{
   Dog good_pupper;
   
   public SleepingState(Dog good_pupper)
   {
      this.good_pupper = good_pupper;
   }

   @Override
   public void giveTreat()
   {
      System.out.println(good_pupper.getName()+" is asleep");
   }

   @Override
   public void callOver()
   {
      System.out.println(good_pupper.getName()+" is asleep and didn't hear you");
   }

   @Override
   public void callLoudly()
   {
      System.out.println(good_pupper.getName()+" woke up!");
      good_pupper.setState(good_pupper.getSitting());
   }
}
