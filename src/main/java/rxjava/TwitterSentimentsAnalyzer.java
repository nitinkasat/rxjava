package rxjava;

import rx.Observable;
import rx.observables.ConnectableObservable;
import twitter4j.Status;

public class TwitterSentimentsAnalyzer {

	public static void main(String[] args) {
		ConnectableObservable<Status> observable = TweetObservable.get(new String[] { "hello" }).publish();
		observable.connect();
		Observable<String> stream = observable.map(Status::getText);
		stream.forEach(System.out::println);
	}

}