import java.util.ArrayList;

public class BestFit implements Fit {
    @Override
    public void fit(ArrayList<Bin> arr, Item item) {
        Bin bin = new Bin();
        
        if(arr.size() == 0){
            bin.update(item);
            arr.add(bin);
            return;
        }
        else {
            int min = 10;
            for (int i = 0; i < arr.size() ; i++) {
                bin = arr.get(i);
                if(bin.check(item)) {
                    if (min > bin.remainCapacity - item.weight) min = i;
                }
            }

            // 다 돌았는데 넣을 곳이 없었다 ? 그러면 통 새로 만들어서 넣어주기
            if(min == 10) {
                bin = new Bin();
                bin.update(item);
                arr.add(bin);
            }
            // min의 값이 바뀌었다면 어딘가에 얘를 최선으로 넣었다는거지
            else {
                bin = arr.get(min);
                bin.update(item);
            }
        }
    }
}
