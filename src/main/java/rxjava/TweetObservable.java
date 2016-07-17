package rxjava;

import rx.Observable;
import twitter4j.FilterQuery;
import twitter4j.Status;
import twitter4j.StatusAdapter;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

public final class TweetObservable {

	private TweetObservable() {
	}

	public static Observable<Status> get(final String[] searchKeywords) {
		return Observable.create(subscriber -> {
			final TwitterStream twitterStream = TwitterStreamFactory.getSingleton();
			twitterStream.addListener(new StatusAdapter() {
				public void onStatus(Status status) {
					subscriber.onNext(status);
				}

				public void onException(Exception ex) {
					subscriber.onError(ex);
				}
			});
			FilterQuery query = new FilterQuery();
			query.language(new String[] { "en" });
			query.follow(173009768);
			twitterStream.filter(query);
		});
	}

}
