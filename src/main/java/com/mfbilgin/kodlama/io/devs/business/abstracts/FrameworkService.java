package com.mfbilgin.kodlama.io.devs.business.abstracts;

import com.mfbilgin.kodlama.io.devs.business.requests.framework.AddFrameworkRequest;
import com.mfbilgin.kodlama.io.devs.business.requests.framework.DeleteFrameworkRequest;
import com.mfbilgin.kodlama.io.devs.business.requests.framework.UpdateFrameworkRequest;
import com.mfbilgin.kodlama.io.devs.business.responses.framework.GetFrameworkResponse;

import java.util.List;

public interface FrameworkService {
    void add(AddFrameworkRequest request);
    void delete(DeleteFrameworkRequest request);
    void update(UpdateFrameworkRequest request);
    List<GetFrameworkResponse> getAll();
    List<GetFrameworkResponse> getByLanguageId(int languageId);
    GetFrameworkResponse getById(int id);

}
