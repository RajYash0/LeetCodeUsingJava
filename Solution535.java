class Codec {
    private Map<String, String> encodeMap = new HashMap<>();
    private Map<String, String> decodeMap = new HashMap<>();
    private final String ALPHABET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final String PREFIX = "http://tinyurl.com/";
    private Random rand = new Random();

    public String encode(String longUrl) {
        if (decodeMap.containsKey(longUrl)) return decodeMap.get(longUrl);
        String shortUrl;
        do {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 6; i++) sb.append(ALPHABET.charAt(rand.nextInt(ALPHABET.length())));
            shortUrl = PREFIX + sb.toString();
        } while (encodeMap.containsKey(shortUrl));
        encodeMap.put(shortUrl, longUrl);
        decodeMap.put(longUrl, shortUrl);
        return shortUrl;
    }

    public String decode(String shortUrl) {
        return encodeMap.getOrDefault(shortUrl, "");
    }
}