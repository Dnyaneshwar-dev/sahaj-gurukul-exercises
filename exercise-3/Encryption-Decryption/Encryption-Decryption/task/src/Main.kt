package encryptdecrypt

fun main() {

    var plaintext = readln();
    var key = readln().toInt();

    var ciphertext = "";
    for(i in 0 until plaintext.length)
    {
        var current_value = plaintext[i].code - 97;

        if(!(current_value >= 0 && current_value <= 25)){
            ciphertext += plaintext[i];
            continue;
        }

        current_value = (current_value + key) % 26;

        ciphertext += ((97 + current_value).toChar());

    }

    println(ciphertext)


}