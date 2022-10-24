import java.text.FieldPosition
import java.util.Scanner;

fun move(currentPosition: Int,number: Int, ladders: HashMap<Int,Int>, snakes: HashMap<Int,Int> ): Int  {

    if(currentPosition + number > 100) return currentPosition

    var newPosition:Int = currentPosition + number

    if(snakes.containsKey(newPosition)){
        newPosition = snakes[newPosition]!!
    }
    else if(ladders.containsKey(newPosition))
    {
        newPosition = ladders[newPosition]!!
    }

    return newPosition
}
fun main(args: Array<String>) {

    // Variables
    var ladders: HashMap<Int,Int> = HashMap<Int,Int> ()
    var snakes: HashMap<Int,Int> = HashMap<Int,Int>()

    // number of ladders
    var numOfLadders: Int = 0;
    try {
        numOfLadders = readln().toInt();
    }
    catch (e: Exception)
    {
        error("Please input Valid Integer(Number of Ladders)")
        return
    }

    // Inputting all ladders
    var i = 0;

    while (i < numOfLadders){
        try {
            var (start, end) = readln().split(" ").map { it.toInt() }

            ladders.put(start,end)

            i += 1

        }
        catch (e: Exception){
            error("Wrong Start and End Values!! Enter Valid Numbers");
        }

    }


    // number of snakes
    var numOfSnakes: Int = 0;

    try {
        numOfSnakes = readln().toInt()
    }
    catch (e:Exception){
        error("Please input Valid Integer(Number of Snakes)")
        return

    }


    // Inputing all snakes
    i = 0

    while (i < numOfSnakes){
        try {
            var (start, end) = readln().split(" ").map { it.toInt() }

            snakes.put(start,end)

            i += 1

        }
        catch (e: Exception){
            error("Wrong Start and End Values!! Enter Valid Numbers");
        }

    }


    // Postion
    var currentPosition = 1;


    // Dice Inputs
    val scanner = Scanner(System.`in`)

    println("Enter The Sequence of numbers on dice Face (Enter 0 to Stop)")

    while (scanner.hasNext())
    {

        try {
            var dice = scanner.nextInt()

            if(dice == 0)
                break

            currentPosition = move(currentPosition,dice,ladders,snakes)
        }
        catch (e: Exception){
            error("Enter Valid Dice Face")
        }
    }


    println("Final Position: " + currentPosition)
    return


}