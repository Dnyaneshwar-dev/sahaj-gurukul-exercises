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

fun main(args: Array<String>) {
    var mode = "enc";
    var key = 0;
    var data = "";

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
        }

    }

    if(mode == "enc"){
        println(encrypt(data,key));
    }
    else
    {
        println(decrypt(data,key));
    }
}