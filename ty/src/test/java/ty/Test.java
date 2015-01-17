package ty;

import com.sina.sae.fetchurl.SaeFetchurl;

public class Test {
	public static void main(String[] args) {
		SaeFetchurl fetchUrl = new SaeFetchurl();

        String a="https://api.weixin.qq.com/sns/oauth2/access_token?appid=wxfb99c16a2f7af851&secret=611f3d39523b6b9f5a7f3828767e52b4&code=0113fc1df632be687da366587d14f58y&grant_type=authorization_code";
        
        String res=fetchUrl.fetch(a);
        System.out.println(res);
	}
}
