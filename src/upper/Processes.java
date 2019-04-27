package upper;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

public abstract class Processes {
	
	//処理先
	private Processes next;
	
	//画像クリックが失敗したらtry-catch内で複数回挑戦するメソッド
	public boolean clickRepeat(Screen screen,String imgAdress,int numberOfTry) {
		for(int i=0;i < numberOfTry;i++) {
			try {
				if(screen.find(imgAdress)!=null) {
					screen.click(imgAdress);
				}
				return true;
			}catch(FindFailed e) {
			}
		}
		return false;
	}
	
	
	//処理の流れ
	public abstract boolean process();
}
