package encryptdecrypt

fun encrypt(plaintext: String, key: Int): String {
    var ciphertext = "";
    for(i in 0 until plaintext.length)
    {
        var current_value = plaintext[i].code - 97;

        current_value = (current_value + key);

        ciphertext += ((97 + current_value).toChar());
    }
    return ciphertext;
}

fun decrypt(ciphertext: String, key: Int): String {
    var plaintext = "";
    for(i in 0 until ciphertext.length)
    {
        var current_value = ciphertext[i].code - 97;

        current_value = (current_value - key);

        plaintext += ((97 + current_value).toChar());
    }
    return plaintext;
}

fun main() {

    var operation = readln();

    var text = readln();

    var key = readln().toInt();

    if(operation == "enc"){
        println(encrypt(text,key));
    }
    else
    {
        println(decrypt(text,key));
    }

}