package twitter;

import org.sikuli.script.Key;

class TwitterMain extends TwitterProcesses {
	//何回クリックしたかを記憶させる
	private int numberOfClicks;
	private boolean flag;

	/*
	 * flagがtrue→スイッチをオフに変更する処理
	 * flagがfalse→スイッチをオンにする処理
	 */

	TwitterMain(boolean flag){
		this.flag=flag;
	}

	@Override
	public boolean process() {
		this.numberOfClicks=0;
		//ページのロードに対処
		wait(5000);
		//その場でクリックしてフォーカスを得る
		this.screen.click();

		if(this.flag==true) {
			//BottomMarker出現までループさせる
			while(this.screen.exists("imgs/twitter/TwitterMain/bottomMarker.PNG")==null) {
				this.offStatus();
				this.screen.keyDown(Key.DOWN);
				this.screen.keyUp(Key.DOWN);
			}
			return true;

		}else if(this.flag==false) {
			//BottomMarker出現までループさせる
			while(this.screen.exists("imgs/twitter/TwitterMain/bottomMarker.PNG")==null) {
				this.onStatus();
				this.screen.keyDown(Key.DOWN);
				this.screen.keyUp(Key.DOWN);
			}
			return true;
		}

		return false;
	}

	//スイッチをオフにする処理
	void offStatus() {

		this.waitClick("imgs/twitter/TwitterMain/onStatus.PNG");
		this.numberOfClicks++;
	}

	void onStatus() {
		this.waitClick("imgs/twitter/TwitterMain/offStatus.PNG");
		this.numberOfClicks++;
	}

	public int getNumOfClicks() {
		return this.numberOfClicks;
	}
}
