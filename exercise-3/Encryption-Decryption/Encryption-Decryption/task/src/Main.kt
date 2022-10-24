package encryptdecrypt
import java.io.File
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

fun main(args: Array<String>) {
    var mode = "enc";
    var key = 0;
    var data = "";
    var inFilePath = "";
    var outFilePath = "";



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

        ciphertext = encrypt(plaintext,key);

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

        plaintext = decrypt(ciphertext,key);

        if(outFilePath != ""){
            File(outFilePath).writeText(plaintext);
        }
        else
        {
            println(plaintext);
        }
    }
}