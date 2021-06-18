package edu.etime.txmcms.services;

import java.util.List;

import edu.etime.txmcms.pojo.ArtType;

public interface WebArtService {

	List<ArtType> selectArtTypeByUsed();

}
