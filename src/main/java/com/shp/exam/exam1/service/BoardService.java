package com.shp.exam.exam1.service;

import com.shp.exam.exam1.container.Container;
import com.shp.exam.exam1.container.ContainerComponent;
import com.shp.exam.exam1.dto.Board;
import com.shp.exam.exam1.repository.BoardRepository;

public class BoardService implements ContainerComponent {
	private BoardRepository boardRepository;
	
	public void init() {
		boardRepository = Container.boardRepository;
	}

	public Board getBoardById(int id) {
		return boardRepository.getBoardById(id);
	}
}
