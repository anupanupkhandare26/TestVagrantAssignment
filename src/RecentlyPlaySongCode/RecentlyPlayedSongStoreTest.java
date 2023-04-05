package RecentlyPlaySongCode;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class RecentlyPlayedSongStoreTest 
{

	private RecentlyPlayedSongsStore store;
	private String[] expectedSongs={"S1", "S2", "S3"};
	private List<String> actualSongs;
	private String userId="";

	
	@BeforeMethod
	public void setUp() 
	{
		store = new RecentlyPlayedSongsStore(3);

	}

	@Test
	public void validateAddNewSongInQueue() 
	{
		// Add songs to store
		userId="user1";
		store.addSong(userId, "S1");
		store.addSong(userId, "S2");
		store.addSong(userId, "S3");

		
		// Verify that only the most recent songs are stored
		actualSongs=store.getRecentlyPlayedSongs(userId);
		Assert.assertEquals(actualSongs.size(), expectedSongs.length, "Incorrect number of songs retrieved");
	    Assert.assertTrue(actualSongs.containsAll(Arrays.asList(expectedSongs)), "Incorrect songs retrieved");
	    Reporter.log(userId+" added new song in Queue: "+actualSongs);
	    
	    // Add more songs to store
	    store.addSong(userId, "S4");
		actualSongs=store.getRecentlyPlayedSongs(userId);
		expectedSongs=new String[] {"S2", "S3", "S4"};
		Assert.assertEquals(actualSongs.size(), expectedSongs.length, "Incorrect number of songs retrieved");
	    Assert.assertTrue(actualSongs.containsAll(Arrays.asList(expectedSongs)), "Incorrect songs retrieved");
	    Reporter.log(userId+" added new song in Queue: "+actualSongs);
	 
	    // Add more songs to store
	    store.addSong(userId, "S2");
		actualSongs=store.getRecentlyPlayedSongs(userId);
		expectedSongs=new String[] {"S3", "S4", "S2"};
		Assert.assertEquals(actualSongs.size(), expectedSongs.length, "Incorrect number of songs retrieved");
	    Assert.assertTrue(actualSongs.containsAll(Arrays.asList(expectedSongs)), "Incorrect songs retrieved");
	    Reporter.log(userId+" added new song in Queue: "+actualSongs);

	    store.addSong(userId, "S1");
		actualSongs=store.getRecentlyPlayedSongs(userId);
		expectedSongs=new String[] {"S4", "S2", "S1"};
		Assert.assertEquals(actualSongs.size(), expectedSongs.length, "Incorrect number of songs retrieved");
	    Assert.assertTrue(actualSongs.containsAll(Arrays.asList(expectedSongs)), "Incorrect songs retrieved");
	    Reporter.log(userId+" added new song in Queue: "+actualSongs);
	}
	
	

	@Test
	public void validateAddNewSongsWithNewUser() 
	{
		// Add songs to store with new User
		userId="2";
		store.addSong(userId, "S1");
		store.addSong(userId, "S2");
		store.addSong(userId, "S3");
		store.addSong(userId, "S4");
		actualSongs=store.getRecentlyPlayedSongs(userId);
		expectedSongs=new String[] {"S2", "S3", "S4"};
		Assert.assertEquals(actualSongs.size(), expectedSongs.length, "Incorrect number of songs retrieved");
	    Assert.assertTrue(actualSongs.containsAll(Arrays.asList(expectedSongs)), "Incorrect songs retrieved");
	    Reporter.log(userId+" added new song in Queue: "+actualSongs);
	    
	    userId="2";
	    store.addSong(userId, "S2");
		actualSongs=store.getRecentlyPlayedSongs(userId);
		expectedSongs=new String[] {"S3", "S4", "S2"};
		Assert.assertEquals(actualSongs.size(), expectedSongs.length, "Incorrect number of songs retrieved");
	    Assert.assertTrue(actualSongs.containsAll(Arrays.asList(expectedSongs)), "Incorrect songs retrieved");
	    Reporter.log(userId+" added new song in Queue: "+actualSongs);

	    userId="2";
	    store.addSong(userId, "S1");
		actualSongs=store.getRecentlyPlayedSongs(userId);
		expectedSongs=new String[] {"S4", "S2", "S1"};
		Assert.assertEquals(actualSongs.size(), expectedSongs.length, "Incorrect number of songs retrieved");
	    Assert.assertTrue(actualSongs.containsAll(Arrays.asList(expectedSongs)), "Incorrect songs retrieved");
	    Reporter.log(userId+" added new song in Queue: "+actualSongs);


	}
	
	@Test
	public void validateTheCapacityDoNotExceeded() 
	{
		// Verify that the capacity of the store is not exceeded
		userId = "User1";
	    store.addSong(userId, "S6");
	    store.addSong(userId, "S7");
	    expectedSongs = new String[]{"S6", "S7"};
	    actualSongs = store.getRecentlyPlayedSongs(userId);
	    Assert.assertEquals(actualSongs.size(), expectedSongs.length, "Incorrect number of songs retrieved");
	    Assert.assertTrue(actualSongs.containsAll(Arrays.asList(expectedSongs)), "Incorrect songs retrieved");
		
	}

	@Test
	public void validateToGetRecentlyPlayedSongsEmpty() 
	{
		List<String> songs = store.getRecentlyPlayedSongs("user1");
		assertEquals(songs.size(), 0);
	}

}
