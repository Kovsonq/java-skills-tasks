package course.checkNPE;

import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.util.Base64Utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Slf4j
public class Test {
    public static void main(String[] args) {
//        NpeTestMap goodSecretExample = getGoodTestMap();
//        if (null != goodSecretExample) {
//            final String encrData = goodSecretExample.getData().get("key");
//            final String decrData = new String(Base64Utils.decodeFromString(encrData));
//
//            final Map<String, Map<String, String>> cfg = createGoodCfgMap(decrData);
//            final String username = cfg.get("registryUrl").get("username");
//            final String password = cfg.get("registryUrl").get("password");
//
//            System.out.println(username + " " + password);
//        }
        System.out.println("---------------------first with npe program --------------------");
        NpeTestMap wrongSecretExample = getWrongTestMap2();
        if (null == wrongSecretExample){
            log.error("Wrong Secret");
            return;
        }

        Map<String, String> data = wrongSecretExample.getData();
        if (null == data) {
            log.error("Wrong Secret data");
            return;
        }

        final String encrData = data.get("key");
        if (null == encrData) {
            log.error("Wrong encr data");
            return;
        }

        final String decrData = new String(Base64Utils.decodeFromString(encrData));
        final Map<String, Map<String, String>> cfg = createGoodCfgMap(decrData);
        if (null == cfg){
            log.error("Wrong CFG");
            return;
        }

        Map<String, String> cfgMap = cfg.get("registryUrl");
        if (null == cfgMap) {
            log.error("Wrong cfgMap");
            return;
        }

        String username = cfgMap.get("username");
        String password = cfgMap.get("password");
        if (null == username || null == password) {
            log.error("Wrong cfgMap");
            return;
        }
        System.out.println(username + " " + password);


        System.out.println("---------------------second with npe program with Optional --------------------");

        NpeTestMap wrongSecretExample2 = getWrongTestMap2();
        if (null != wrongSecretExample2) {
            try {
                String decrData2 = Optional.ofNullable(wrongSecretExample2.getData())
                        .map(secret -> secret.get("key"))
                        .map(value ->  new String(Base64Utils.decodeFromString(value)))
                        .orElseThrow(() -> new DockerSecretParsingException("Cant parse docker secret. No data."));
                System.out.println(decrData2);
                final Map<String, Map<String, String>> cfg2 = createWrongCfgMap(decrData);
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
