# Building a betting host

This program is aimed to calculate the dividends for a simplified form of Tote betting for Tabcorp.

## Get started

Tote betting involves punters choosing the outcome of a race by placing bets into a pool of money. Punters who successfully predict the outcome of a race take a share of the pool proportional to their stake. For example, a punter who places a $2 bet on a winning selection would receive twice the winnings of a punter who placed a $1 stake. Tabcorp takes a commission out of the pool before it is split between winning punters.

The calculator must support three products with the following rules:

**WIN**

>Punters must choose the winner of a race

>Tabcorp takes a 15% commission from the Win pool

>The remaining total is split, proportionally to stake, amongst punters who chose the correct winning horse.

**PLACE**

>Punters must choose the first, second or third place horse in a race

>Tabcorp takes a 12% commission from the Place pool

>The total pool is split evenly into 3 and each of these amounts is then split, proportionally to stake, amongst the punters who chose each placed horse

**EXACTA**

>Punters must choose the first and second place runners in a race in the correct order

>Tabcorp takes an 18% commission from the Exacta pool

>The remaining total is split, proportionally to stake, amongst punters who chose the correct first and second horse in correct order

After a race has been run, Tabcorp publishes the dividends for each product. This is the return for a $1 stake for each paying selection in the race. All dividends are calculated to the nearest $0.01.

## Execute and Test

To run this program, following those steps:

> Create a new Java project in your IDE

> Unzip file ToteBetting.zip and copy folder **src** to replace the existing **src** folder in your project. 

> Go back to IDE: right-click on your project and click **Refresh**

> Open **CalculateDividends.java** under implement folder and right_click to select **Run As** and then select **Java Application**

> Copy your input: list of bets to **Console** (there is an example in test file)

> Finally, output will be displayed in Console below.

