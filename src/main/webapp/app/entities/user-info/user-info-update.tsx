import React from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col, Label } from 'reactstrap';
import { AvForm, AvGroup, AvInput, AvField } from 'availity-reactstrap-validation';
// tslint:disable-next-line:no-unused-variable
import { Translate, translate, ICrudGetAction, ICrudGetAllAction, ICrudPutAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { IRootState } from 'app/shared/reducers';

import { IUser } from 'app/shared/model/user.model';
import { getUsers } from 'app/modules/administration/user-management/user-management.reducer';
import { getEntity, updateEntity, createEntity, reset } from './user-info.reducer';
import { IUserInfo } from 'app/shared/model/user-info.model';
// tslint:disable-next-line:no-unused-variable
import { convertDateTimeFromServer } from 'app/shared/util/date-utils';
import { mapIdList } from 'app/shared/util/entity-utils';

export interface IUserInfoUpdateProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export interface IUserInfoUpdateState {
  isNew: boolean;
  userinforlsId: string;
}

export class UserInfoUpdate extends React.Component<IUserInfoUpdateProps, IUserInfoUpdateState> {
  constructor(props) {
    super(props);
    this.state = {
      userinforlsId: '0',
      isNew: !this.props.match.params || !this.props.match.params.id
    };
  }

  componentWillUpdate(nextProps, nextState) {
    if (nextProps.updateSuccess !== this.props.updateSuccess && nextProps.updateSuccess) {
      this.handleClose();
    }
  }

  componentDidMount() {
    if (!this.state.isNew) {
      this.props.getEntity(this.props.match.params.id);
    }

    this.props.getUsers();
  }

  saveEntity = (event, errors, values) => {
    if (errors.length === 0) {
      const { userInfoEntity } = this.props;
      const entity = {
        ...userInfoEntity,
        ...values
      };

      if (this.state.isNew) {
        this.props.createEntity(entity);
      } else {
        this.props.updateEntity(entity);
      }
    }
  };

  handleClose = () => {
    this.props.history.push('/entity/user-info');
  };

  render() {
    const { userInfoEntity, users, loading, updating } = this.props;
    const { isNew } = this.state;

    return (
      <div>
        <Row className="justify-content-center">
          <Col md="8">
            <h2 id="ecoLearningApp.userInfo.home.createOrEditLabel">
              <Translate contentKey="ecoLearningApp.userInfo.home.createOrEditLabel">Create or edit a UserInfo</Translate>
            </h2>
          </Col>
        </Row>
        <Row className="justify-content-center">
          <Col md="8">
            {loading ? (
              <p>Loading...</p>
            ) : (
              <AvForm model={isNew ? {} : userInfoEntity} onSubmit={this.saveEntity}>
                {!isNew ? (
                  <AvGroup>
                    <Label for="id">
                      <Translate contentKey="global.field.id">ID</Translate>
                    </Label>
                    <AvInput id="user-info-id" type="text" className="form-control" name="id" required readOnly />
                  </AvGroup>
                ) : null}
                <AvGroup>
                  <Label id="phoneLabel" for="phone">
                    <Translate contentKey="ecoLearningApp.userInfo.phone">Phone</Translate>
                  </Label>
                  <AvField id="user-info-phone" type="text" name="phone" />
                </AvGroup>
                <AvGroup>
                  <Label id="classLevelLabel" for="classLevel">
                    <Translate contentKey="ecoLearningApp.userInfo.classLevel">Class Level</Translate>
                  </Label>
                  <AvField id="user-info-classLevel" type="text" name="classLevel" />
                </AvGroup>
                <AvGroup>
                  <Label id="schoolLabel" for="school">
                    <Translate contentKey="ecoLearningApp.userInfo.school">School</Translate>
                  </Label>
                  <AvField id="user-info-school" type="text" name="school" />
                </AvGroup>
                <AvGroup>
                  <Label id="locationLabel" for="location">
                    <Translate contentKey="ecoLearningApp.userInfo.location">Location</Translate>
                  </Label>
                  <AvField id="user-info-location" type="text" name="location" />
                </AvGroup>
                <AvGroup>
                  <Label id="genderLabel" for="gender">
                    <Translate contentKey="ecoLearningApp.userInfo.gender">Gender</Translate>
                  </Label>
                  <AvField id="user-info-gender" type="text" name="gender" />
                </AvGroup>
                <AvGroup>
                  <Label id="dateofbirthLabel" for="dateofbirth">
                    <Translate contentKey="ecoLearningApp.userInfo.dateofbirth">Dateofbirth</Translate>
                  </Label>
                  <AvField id="user-info-dateofbirth" type="date" className="form-control" name="dateofbirth" />
                </AvGroup>
                <AvGroup>
                  <Label id="deviceLabel" for="device">
                    <Translate contentKey="ecoLearningApp.userInfo.device">Device</Translate>
                  </Label>
                  <AvField id="user-info-device" type="text" name="device" />
                </AvGroup>
                <AvGroup>
                  <Label id="deviceTokenLabel" for="deviceToken">
                    <Translate contentKey="ecoLearningApp.userInfo.deviceToken">Device Token</Translate>
                  </Label>
                  <AvField id="user-info-deviceToken" type="text" name="deviceToken" />
                </AvGroup>
                <AvGroup>
                  <Label for="userinforls.login">
                    <Translate contentKey="ecoLearningApp.userInfo.userinforls">Userinforls</Translate>
                  </Label>
                  <AvInput id="user-info-userinforls" type="select" className="form-control" name="userinforlsId">
                    <option value="" key="0" />
                    {users
                      ? users.map(otherEntity => (
                          <option value={otherEntity.id} key={otherEntity.id}>
                            {otherEntity.login}
                          </option>
                        ))
                      : null}
                  </AvInput>
                </AvGroup>
                <Button tag={Link} id="cancel-save" to="/entity/user-info" replace color="info">
                  <FontAwesomeIcon icon="arrow-left" />&nbsp;
                  <span className="d-none d-md-inline">
                    <Translate contentKey="entity.action.back">Back</Translate>
                  </span>
                </Button>
                &nbsp;
                <Button color="primary" id="save-entity" type="submit" disabled={updating}>
                  <FontAwesomeIcon icon="save" />&nbsp;
                  <Translate contentKey="entity.action.save">Save</Translate>
                </Button>
              </AvForm>
            )}
          </Col>
        </Row>
      </div>
    );
  }
}

const mapStateToProps = (storeState: IRootState) => ({
  users: storeState.userManagement.users,
  userInfoEntity: storeState.userInfo.entity,
  loading: storeState.userInfo.loading,
  updating: storeState.userInfo.updating,
  updateSuccess: storeState.userInfo.updateSuccess
});

const mapDispatchToProps = {
  getUsers,
  getEntity,
  updateEntity,
  createEntity,
  reset
};

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(UserInfoUpdate);
