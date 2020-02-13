package me.wonsey.ood.states;

import me.wonsey.ood.device.Dog;

public class RunningState implements State
{
   Dog good_pupper;
   
   public RunningState(Dog good_pupper)
   {
      this.good_pupper = good_pupper;
   }

   @Override
   public void giveTreat()
   {
      System.out.println(good_pupper.getName()+" is too distracted to notice the treat");
   }

   @Override
   public void callOver()
   {
      System.out.println(good_pupper.getName()+" doesn't notice you calling it");
   }

   @Override
   public void callLoudly()
   {
      System.out.println(good_pupper.getName()+" notices you and stops and sits");
      good_pupper.setState(good_pupper.getSitting());
   }
}
