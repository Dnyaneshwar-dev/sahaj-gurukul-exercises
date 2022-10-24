package encryptdecrypt
import java.io.File
fun encryptUnicode(plaintext: String, key: Int): String {
    var ciphertext = "";
    for(i in 0 until plaintext.length)
    {
        var currentValue = plaintext[i].code - 97;

        currentValue = (currentValue + key);

        ciphertext += ((97 + currentValue).toChar());
    }
    return ciphertext;
}

fun decryptUnicode(ciphertext: String, key: Int): String {
    var plaintext = "";
    for(i in 0 until ciphertext.length)
    {
        var currentValue = ciphertext[i].code - 97;

        currentValue = (currentValue - key);

        plaintext += ((97 + currentValue).toChar());
    }
    return plaintext;
}

fun shiftEncrypt(plaintext: String, key: Int): String {

    var shiftedText = "";

    for(i in 0 until plaintext.length){
        var ch = plaintext[i];
        var currentCode = ch.code

        if(currentCode >= 97 && currentCode  <= 122)
        {
            currentCode -= 97
            currentCode += key
            currentCode %= 26
            currentCode += 97

            shiftedText += currentCode.toChar();
        }
        else if(currentCode >= 65 && currentCode <= 90){

            currentCode -= 65
            currentCode += key
            currentCode %= 26
            currentCode += 65

            shiftedText += currentCode.toChar();

            shiftedText += currentCode.toChar();
        }
        else
        {
            shiftedText += ch;
        }
    }

    return shiftedText
}

fun shiftDecrypt(ciphertext: String, key: Int): String {

    var shiftedText = "";

    for(i in 0 until ciphertext.length){
        var ch = ciphertext[i];
        var currentCode = ch.code

        if(currentCode >= 97 && currentCode  <= 122)
        {
            currentCode -= 97
            currentCode -= key
            currentCode += 26
            currentCode %= 26
            currentCode += 97

            shiftedText += currentCode.toChar();
        }
        else if(currentCode >= 65 && currentCode <= 90){

            currentCode -= 65
            currentCode -= key
            currentCode += 26
            currentCode %= 26
            currentCode += 65

            shiftedText += currentCode.toChar();

            shiftedText += currentCode.toChar();
        }
        else
        {
            shiftedText += ch;
        }
    }

    return shiftedText
}

fun main(args: Array<String>) {
    var mode = "enc";
    var key = 0;
    var data = "";
    var inFilePath = "";
    var outFilePath = "";
    var algorithm = "shift";



    for(i in 0 until args.size step 2)
    {
        var operation = args[i];
        var nextData = args[i+1];

        when(operation){
            "-mode" -> {
                mode = nextData;
            }
            "-key" ->{
              key = nextData.toInt();
            }
            "-data" ->{
                data = nextData;
            }
            "-in" -> {
                inFilePath = nextData;
            }

            "-out" -> {
                outFilePath = nextData;
            }
            "-alg" ->{
                algorithm = nextData;
            }
        }
    }

    if(mode == "enc"){
        var ciphertext = "";
        var plaintext = "";

        if(inFilePath != "")
        {
            plaintext = File(inFilePath).readText();
        }
        else if(data != "")
        {
            plaintext = data;
        }

        if(algorithm == "unicode")
            ciphertext = encryptUnicode(plaintext,key);
        else
            ciphertext = shiftEncrypt(plaintext,key)

        if(outFilePath != ""){
            File(outFilePath).writeText(ciphertext);
        }
        else
        {
            println(ciphertext);
        }
    }
    else
    {
        var ciphertext = "";
        var plaintext = "";

        if(inFilePath != "")
        {
            ciphertext = File(inFilePath).readText();
        }
        else if(data != "")
        {
            ciphertext = data;
        }
        if(algorithm == "unicode")
            plaintext = decryptUnicode(ciphertext,key);
        else
            plaintext = shiftDecrypt(ciphertext,key)

        if(outFilePath != ""){
            File(outFilePath).writeText(plaintext);
        }
        else
        {
            println(plaintext);
        }
    }
}