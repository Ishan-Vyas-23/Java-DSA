package HashMap;

public class MapUsingHash {
    private Entity[] entities;

    public MapUsingHash() {
        entities = new Entity[100];
    }

    public void put(String key , String val){
        int hash = Math.abs(key.hashCode()%entities.length);
        entities[hash] = new Entity(key,val);
    }

    public String get(String key){
        int hash = Math.abs(key.hashCode()%entities.length);
        if(entities[hash]!=null && entities[hash].key.equals(key)){
            return entities[hash].val;
        }
        return null;
    }

    public void remove(String key){
        int hash = Math.abs(key.hashCode()%entities.length);
        if(entities[hash]!=null && entities[hash].key.equals(key) ){
            entities[hash] = null;
        }
    }

    //key value pair block
    private class Entity{
        String key ;
        String val;

        public Entity(String key, String val) {
            this.key = key;
            this.val = val;
        }
    }
}
