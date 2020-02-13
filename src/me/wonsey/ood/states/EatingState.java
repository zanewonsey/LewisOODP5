package me.wonsey.ood.states;

import me.wonsey.ood.device.Dog;

public class EatingState implements State
{
   Dog good_pupper;
   
   public EatingState(Dog good_pupper)
   {
      this.good_pupper = good_pupper;
   }

   @Override
   public void giveTreat()
   {
      System.out.println(good_pupper.getName()+" keeps eating");
   }

   @Override
   public void callOver()
   {
      System.out.println(good_pupper.getName()+" ignores you");
   }

   @Override
   public void callLoudly()
   {
      System.out.println(good_pupper.getName()+" barks at you");
      good_pupper.setState(good_pupper.getBarking());
   }
}
