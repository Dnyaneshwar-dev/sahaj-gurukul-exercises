package encryptdecrypt

fun main() {
    var plaintext = "we found a treasure!";
    var ciphertext = "";

    for(ch in plaintext)
    {
//         var ch = Char = ciphertext[i];
        var value = ch.code;

        if(value >= 97 && value <= 122)
        {
            value -= 97;

            var result = 122 - value;
            ciphertext += result.toChar();
        }
        else
        {
            ciphertext += ch;
        }
    }

    println(ciphertext);


}