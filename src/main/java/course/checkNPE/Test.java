package course.checkNPE;

import org.springframework.lang.Nullable;
import org.springframework.util.Base64Utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Test {
    public static void main(String[] args) {
        NpeTestMap goodSecretExample = getGoodTestMap();
        if (null != goodSecretExample) {
            final String encrData = goodSecretExample.getData().get("key");
            final String decrData = new String(Base64Utils.decodeFromString(encrData));

            final Map<String, Map<String, String>> cfg = createGoodCfgMap(decrData);
            final String username = cfg.get("registryUrl").get("username");
            final String password = cfg.get("registryUrl").get("password");

            System.out.println(username + " " + password);
        }
        System.out.println("---------------------first with npe program --------------------");
        NpeTestMap wrongSecretExample = getWrongTestMap2();
        if (null != wrongSecretExample) {
            if (null != wrongSecretExample.getData()){
                final String encrData = wrongSecretExample.getData().get("key");
                if (null != encrData) {
                    final String decrData = new String(Base64Utils.decodeFromString(encrData));
                    final Map<String, Map<String, String>> cfg = createGoodCfgMap(decrData);
                    Map<String, String> cfgMap = cfg.get("registryUrl");
                    if (null != cfgMap){
                        String username = cfgMap.get("username");
                        String password = cfgMap.get("password");
                        if (null != username && null != password){
                            System.out.println(username + " " + password);
                        }
                    }
                }
            }
            System.out.println("Cant parse docker secret.");
            return;
        }

        System.out.println("---------------------second with npe program with Optional --------------------");

        NpeTestMap wrongSecretExample2 = getWrongTestMap2();
        if (null != wrongSecretExample2) {
            try {
                String decrData = Optional.ofNullable(wrongSecretExample2.getData())
                        .map(secret ->  new String(Base64Utils.decodeFromString(secret.get("key"))))
                        .orElseThrow(() -> new DockerSecretParsingException("Cant parse docker secret. No data."));
                System.out.println(decrData);
                final Map<String, Map<String, String>> cfg = createWrongCfgMap(decrData);
            } catch (final DockerSecretParsingException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private static Map<String, Map<String, String>> createGoodCfgMap(final String value) {
        final Map<String, Map<String, String>> cfg = new HashMap<>();
        Map<String, String> registryMap = new HashMap<>();
        registryMap.put("username", "exampleName");
        registryMap.put("password", value);
        cfg.put("registryUrl", registryMap);
        return cfg;
    }

    private static Map<String, Map<String, String>> createWrongCfgMap(final String value) {
        final Map<String, Map<String, String>> cfg = new HashMap<>();
        Map<String, String> registryMap = new HashMap<>();
        registryMap.put("username", "exampleName");
        registryMap.put("password", value);
        cfg.put("wrongRegistryUrl", registryMap);
        return cfg;
    }

    @Nullable
    private static NpeTestMap getGoodTestMap() {
        NpeTestMap goodSecretExample = new NpeTestMap();
        Map<String,String> insertedMap = new HashMap<>();
        insertedMap.put("key", "dGVzdFBhc3N3b3Jk");
        goodSecretExample.setData(insertedMap);
        if (new NpeTestMap().equals(goodSecretExample)){
            return null;
        }
        return goodSecretExample;
    }

    private static NpeTestMap getWrongTestMap() {
        return new NpeTestMap();
    }

    @Nullable
    private static NpeTestMap getWrongTestMap2() {
        NpeTestMap goodSecretExample = new NpeTestMap();
        Map<String,String> insertedMap = new HashMap<>();
        insertedMap.put("key2", "dGVzdFBhc3N3b3Jk");
        goodSecretExample.setData(insertedMap);
        if (new NpeTestMap().equals(goodSecretExample)){
            return null;
        }
        return goodSecretExample;
    }
}
