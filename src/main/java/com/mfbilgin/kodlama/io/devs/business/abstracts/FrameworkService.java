package com.mfbilgin.kodlama.io.devs.business.abstracts;

import com.mfbilgin.kodlama.io.devs.business.requests.framework.AddFrameworkRequest;
import com.mfbilgin.kodlama.io.devs.business.requests.framework.UpdateFrameworkRequest;
import com.mfbilgin.kodlama.io.devs.business.responses.framework.GetAllFrameworkResponse;
import com.mfbilgin.kodlama.io.devs.business.responses.framework.GetByIdFrameworkResponse;
import com.mfbilgin.kodlama.io.devs.business.responses.framework.GetByLanguageIdFrameworkResponse;

import java.util.List;

public interface FrameworkService {
    void add(AddFrameworkRequest request);

    void update(UpdateFrameworkRequest request);

    void delete(int id);

    List<GetAllFrameworkResponse> getAll();

    List<GetByLanguageIdFrameworkResponse> getByLanguageId(int languageId);

    GetByIdFrameworkResponse getById(int id);

}
