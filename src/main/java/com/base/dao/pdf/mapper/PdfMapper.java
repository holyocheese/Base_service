package com.base.dao.pdf.mapper;

import com.base.dao.pdf.entity.Pdf;
import tk.mybatis.mapper.common.Mapper;

public interface PdfMapper extends Mapper<Pdf> {
	int selectMaxId();
}