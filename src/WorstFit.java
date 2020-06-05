import java.util.ArrayList;

public class WorstFit implements Fit {
    @Override
    public void fit(ArrayList<Bin> arr, Item item) {
        Bin bin = new Bin();

        if(arr.size() == 0){
            bin.update(item);
            arr.add(bin);
            return;
        }
        else {
            int max = -1;
            for (int i = 0; i < arr.size() ; i++) {
                bin = arr.get(i);
                if(bin.check(item)) {
                    if (max < bin.remainCapacity - item.weight) max = i;
                }
            }

            // 다 돌았는데 넣을 곳이 없었다 ? 그러면 통 새로 만들어서 넣어주기
            if(max == -1) {
                bin = new Bin();
                bin.update(item);
                arr.add(bin);
            }
            // max의 값이 바뀌었다면 최악으로 들어갈 곳을 찾았다는거지
            else {
                bin = arr.get(max);
                bin.update(item);
            }
        }
    }
}
